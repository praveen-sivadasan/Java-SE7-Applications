package actors;

import actor.messages.Messages;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;

/**
 * This actor counts number words in a single line
 * 
 * @author akashnagesh
 *
 */
public class WordsInLineActor extends UntypedActor {

	private ActorRef parentActorRef;

	public WordsInLineActor(ActorRef actorRef) {
		this.parentActorRef = actorRef;
	}

	@Override
	public void onReceive(Object msg) throws Throwable {
		String line = (String) msg;
		Integer count = 0;
		int i = 1;
		for (i = 1; i < line.length(); i++) {
			if (line.charAt(i) == ' ' && line.charAt(i - 1) != ' ') {
				count++;
			}
		}
		if (count > 0 && (line.length() != 0 && line.charAt(line.length() - 1) != ' '))
			++count;
		parentActorRef.tell(new Messages.LineCountMessage(count), getSelf());
	}
}
