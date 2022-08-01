package application.model.CommonSV;

public class ResponseDetail {
    private String status;
    private Object classInfo;
    private String message;
    private String Action;

    public Object getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(Object classInfo) {
        this.classInfo = classInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    @Override
    public String toString() {
        return String.format("""
                        [ Message = '%s'
                          Status = '%s'
                          Action = '%s'
                          Class: %s
                        ]""",
                getMessage(),
                getStatus(),
                getStatus(),
                getClassInfo().toString());
    }
}
