package actor.messages;

import java.io.File;

/**
 * Messages that are passed around the actors are usually immutable classes.
 * Think how you go about creating immutable classes:) Make them all static
 * classes inside the Messages class.
 * 
 * This class should have all the immutable messages that you need to pass
 * around actors. You are free to add more classes(Messages) that you think is
 * necessary
 * 
 * @author akashnagesh
 *
 */
public class Messages {
	public static final String NO_FILES_FOUND = "No files found in directory";
	
	/*
	 * Total word count
	 */
	public static class TotalCountMessage {

		private final Integer totalCount;

		public TotalCountMessage(Integer totalCount) {
			this.totalCount = totalCount;
		}

		public Integer getTotalCount() {
			return totalCount;
		}

		@Override
		public String toString() {
			return String.valueOf(totalCount);
		}
	}

	/*
	 * File word count
	 */
	public static class FileCountMessage {

		private final Integer fileCount;

		public FileCountMessage(Integer fileCount) {
			this.fileCount = fileCount;
		}

		public Integer getFileCount() {
			return fileCount;
		}
	}

	/*
	 * Line word count
	 */
	public static class LineCountMessage {

		private final Integer lineCount;

		public LineCountMessage(Integer lineCount) {
			this.lineCount = lineCount;
		}

		public Integer getLineCount() {
			return lineCount;
		}
	}

	/*
	 * Message between WordsInLineActor and WordCountInaFileActor
	 */
	public static class FileMessage {

		private final File file;

		public FileMessage(File file) {
			this.file = file;
		}

		public File getFile() {
			return file;
		}
	}

}