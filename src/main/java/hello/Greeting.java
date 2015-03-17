package hello;

public class Greeting {

    private final long id;
    private final String content;
    private final String name;

    public Greeting(long id, String content,String name) {
        this.id = id;
        this.content = content;
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    
    public String getName(){
    	return name;
    }
}


