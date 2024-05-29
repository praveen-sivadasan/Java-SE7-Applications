package actors;

import java.io.File;
import java.util.Scanner;

import actor.messages.Messages;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * this actor reads the file line by line and sends them to
 * {@code WordsInLineActor} to count the words in line. Upon geting the results,
 * It sends the result to it's parent actor {@code WordCount}
 * 
 * @author akashnagesh
 *
 */
public class WordCountInAFileActor extends UntypedActor {

	private ActorRef parentActorRef;

	private Integer responseCount = 0;
	private Integer maxLineCount = 0;
	public Integer wordCount = 0;

	public WordCountInAFileActor(ActorRef actorRef) {
		this.parentActorRef = actorRef;
	}

	@Override
	public void onReceive(Object msg) throws Throwable {
		if (msg instanceof Messages.LineCountMessage) {
			wordCount += ((Messages.LineCountMessage) msg).getLineCount();
			if ((++responseCount).equals(maxLineCount)) {
				System.out.println("File " + getSelf().toString() + " word count: " + wordCount);
				parentActorRef.tell(new Messages.FileCountMessage(wordCount), getSelf());
			}

		} else if (msg instanceof Messages.FileMessage) {
			File file = ((Messages.FileMessage) msg).getFile();
			Scanner scanner = new Scanner(file);
			int lineNum = 0;
			while (scanner.hasNext()) {
				maxLineCount++;
				Props wordsInLineActorProp = Props.create(WordsInLineActor.class, getSelf());
				ActorRef wordsInLineActorNode = getContext().actorOf(wordsInLineActorProp,
						file.getName() + "_" + (++lineNum));
				wordsInLineActorNode.tell(scanner.nextLine(), getSelf());
			}
			scanner.close();
		}
	}
}
