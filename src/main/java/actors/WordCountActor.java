package actors;

import java.io.File;

import actor.messages.Messages;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * This is the main actor and the only actor that is created directly under the
 * {@code ActorSystem} This actor creates more child actors
 * {@code WordCountInAFileActor} depending upon the number of files in the given
 * directory structure
 * 
 * @author akashnagesh
 *
 */
public class WordCountActor extends UntypedActor {

	ActorRef parentSender;
	private Integer count = 0;
	private Integer responseCount = 0;
	private Integer maxFileCount = 0;

	public WordCountActor() {
	}

	@Override
	public void onReceive(Object msg) {
		if (msg instanceof Messages.FileCountMessage) {
			count += ((Messages.FileCountMessage) msg).getFileCount();
			if ((++responseCount).equals(maxFileCount)) {
				parentSender.tell(new Messages.TotalCountMessage(count), getSelf());
			}
		} else if (msg instanceof String) {
			parentSender = getSender();
			File[] directoryListing = (new File((String) msg)).listFiles();
			if (directoryListing != null) {
				maxFileCount = directoryListing.length;
				for (File file : directoryListing) {
					Props wordCountInAFileActorProp = Props.create(WordCountInAFileActor.class, getSelf());
					ActorRef wordCountInAFileActorNode = getContext().actorOf(wordCountInAFileActorProp,
							file.getName());
					wordCountInAFileActorNode.tell(new Messages.FileMessage(file), getSelf());
				}
			} else {
				System.out.println(Messages.NO_FILES_FOUND.toString());
			}
		}
	}
}
