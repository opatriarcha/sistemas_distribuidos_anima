package org.sd.rmi.simpleRmi.messenger;

/**
 *
 * @author orlando
 */
import java.io.Serializable;
import java.util.Objects;

public class Message implements Serializable {
	
	private String messageText;
	
	private String contentType;
	
	public Message() {
	}
	
	public Message(String messageText, String contentType) {
		
		this.messageText = messageText;
		this.contentType = contentType;
	}
	
	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.messageText);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Message other = (Message) obj;
        return Objects.equals(this.messageText, other.messageText);
    }
	
        
}

