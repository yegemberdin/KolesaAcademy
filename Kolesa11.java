import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import java.util.*;

public class Comment {
    
    private long id;
    private long userId;
    private long replyTo;
    private String name;
    private String content;
    
   public Comment(long id, long userId, long replyTo, String name, String content) {
        this.id = id;
        this.userId = userId;
        this.replyTo = replyTo;
        this.name = name;
        this.content = content;
    }
    
    public long getId() {
		return id;
	}
    public long getUserId() {
		return userId;
	}
    public long getReplyTo() {
		return replyTo;
	}
    public String getName() {
		return name;
	}
    public String getContent() {
		return content;}
    
    @Override
    public String toString() {
        return "[" + id + ", " + userId + ", " + replyTo + ", " + name + ", " + content + "]";
    }
    
}

public interface CommentDataFactory<T extends Map> {
	T createComemntStructure(List<Comment> comments);
}



public class Factory implements CommentDataFactory {
	@Override
	public Map createComemntStructure(List<Comment> list) {
        Map<Long, StructuredComment> map = new HashMap<>();
        StructuredComment structuredComment = new StructuredComment();
        for (Comment comment : list) {
            structuredComment.setId(comment.getId());
            structuredComment.setName(comment.getName());
            structuredComment.setUserId(comment.getUserId());
            structuredComment.setContent(comment.getContent());
            if (comment.getReplyTo() != 0) {//if it is answer for other comment
                map.get(comment.getReplyTo()).getListOfReplies().add(structuredComment);//so some comments will be in another some comments-main idea
            }
            map.put(comment.getId(), structuredComment);
        }
        return map;
}
public class StructuredComment {
    private long id;
    private long userId;
    private String name;
    private String content;
    private List<StructuredComment> listOfReplies;

    public StructuredComment() {
        listOfReplies = new ArrayList<>();
    }// empty constructor creates list

    public long getId() {
		return id;
	}
    public void setId(long id) {
       this.id = id;
    }
    public long getUserId() {
		return userId;
	}
    public void setUserId(long userId) {
       this.userId = userId;
    }
    public long getListOfReplies() {
		return listOfReplies;
	}
    public String getName() {
		return name;
	}
    public void setName(String name) {
       this.name = name;
    }

    public String getContent() {
		return content;}

    public void setContent(String content) {
       this.content = content;
    }
}

