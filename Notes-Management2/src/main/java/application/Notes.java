package application;

/**
 * @author datta
 *
 */
public class Notes {
	private int noteId;


	private String title;
	private String note;
	private String dateTime;
	
	public Notes() {
		
	}

	public Notes(String title, String note, String dateTime) {
		this.title = title;
		this.note = note;
		this.dateTime = dateTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	
	
}
