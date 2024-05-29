package actors;

import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import actor.messages.Messages;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.AskTimeoutException;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;

/**
 * Main class for your wordcount actor system.
 * 
 * @author akashnagesh
 *
 */
public class WordCount {

	public static void main(String[] args) {
		try {
			ActorSystem actorSystem = ActorSystem.create("wordcounter");
			/*
			 * Create the WordCountActor and send it the StartProcessingFolder
			 * message. Once you get back the response, use it to print the
			 * result. Remember, there is only one actor directly under the
			 * ActorSystem. Also, do not forget to shutdown the actorsystem
			 */
			
			URL url = Test.class.getClassLoader().getResource("data");
		    URI uri = new URI(url.toString());
		    String path = (uri.getPath()).substring(1, uri.getPath().length());
		    
			Props wordCountActorProp = Props.create(WordCountActor.class);
			ActorRef wordCountActorNode = actorSystem.actorOf(wordCountActorProp, "Word_Count_Actor_Ref");
			try {
				final Timeout timeout = new Timeout(12, TimeUnit.SECONDS);
				final Future<Object> future = Patterns.ask(wordCountActorNode, path, timeout);
				final Messages.TotalCountMessage result = (Messages.TotalCountMessage) Await.result(future,
						timeout.duration());
				System.out.println("Final count:" + result);
			} catch (AskTimeoutException e) {
				e.printStackTrace();
			}
			actorSystem.terminate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
