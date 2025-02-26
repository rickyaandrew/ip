package seedu.duke.tasks;

import java.util.ArrayList;

public class Task {
    protected final String description;
    protected final String dateTime;
    protected final boolean isDone;
    protected final ArrayList<String> tags;
    protected AfterTask afterTask;

    /**
     * Constructor. Default having the isDone parameter to be set as false and
     * dateTime set as none.
     * 
     * @param description is the description of the {@code Task}.
     */
    public Task(String description) {
        this.description = description;
        this.dateTime = "";
        this.isDone = false;
        this.tags = new ArrayList<String>();
    }

    /**
     * Second Constructor. Default having the isDone parameter to be set as false.
     * 
     * @param description is the description of the {@code Task}.
     * @param dateTime    is the description of the location and time for the
     *                    {@code Task}.
     */
    public Task(String description, String dateTime) {
        this.description = description;
        this.dateTime = dateTime;
        this.isDone = false;
        this.tags = new ArrayList<String>();
    }

    /**
     * Third Constructor. Default having the dateTime parameter to be set as empty
     * string as it is not needed.
     * 
     * @param description is the description of the {@code Task}.
     * @param isDone      determine whether the {@code Task} is completed or not.
     */
    public Task(String description, boolean isDone, ArrayList<String> tags) {
        this.description = description;
        this.dateTime = "";
        this.isDone = isDone;
        this.tags = tags;
    }

    /**
     * Fourth Constructor. Initialising the parameters of the {@code Task}.
     * 
     * @param description is the description of the {@code Task}.
     * @param dateTime    is the description of the location and time for the
     *                    {@code Task}.
     * @param isDone      determine whether the {@code Task} is completed or not.
     */
    public Task(String description, String dateTime, boolean isDone, ArrayList<String> tags) {
        this.description = description;
        this.dateTime = dateTime;
        this.isDone = isDone;
        this.tags = tags;
    }

    /**
     * Initialises an {@code AfterTask} into this {@code Task}.
     * 
     * @param afterTask is a following {@code ToDos} which will be available only
     *                  when the current {@code Task} is marked as done.
     */
    public void setAfterTask(AfterTask afterTask) {
        this.afterTask = afterTask;
    }

    public AfterTask getAfterTask() {
        return this.afterTask;
    }

    /**
     * Retrieves the dateTime of the current {@code Task}.
     * 
     * @return a {@code String}, the dateTime of the current {@code Task}.
     */
    public String getDateTime() {
        return this.dateTime;
    }

    /**
     * Retrieves the isDone property of the current {@code Task} object.
     * 
     * @return the current isDone property of this object.
     */
    public boolean getIsDone() {
        return this.isDone;
    }

    /**
     * Retrieves the symbol of the current object. Different object and child have
     * different symbols that represents them.
     * 
     * @return a fixed parent symbol "parent-task".
     */
    public String getSymbol() {
        return "parent-task";
    }

    /**
     * Retrieves the description of the current {@code Task} object.
     * 
     * @return a String which describes the current {@code Task} object.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Retrieves the status icon which depends on the isDone status of the current
     * object.
     * 
     * @return "X" if isDone is true, else it will return " ".
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Marks the current {@code Task} as done.
     * 
     * @return a new {@code Task} object with the same description, but setting
     *         isDone property to be true.
     */
    public Task markAsDone() {
        return new Task(this.getDescription(), true, this.getTags());
    }

    /**
     * Checks if there is an {@code AfterTask} tied to this {@code Task}.
     * 
     * @return a boolean if there is an {@code AfterTask} tied to this {@code Task}.
     */
    public boolean hasAfterTask() {
        return this.afterTask != null;
    }

    /**
     * Getter method, gets the tags for this {@code Task}.
     * 
     * @return {@code ArrayList<String>} which contains all the tags for this
     *         {@code Task}.
     */
    public ArrayList<String> getTags() {
        return this.tags;
    }

    /**
     * Checks if this {@code Task} have any tags.
     * 
     * @return a boolean, if this {@code Task} has any tags to it.
     */
    public boolean hasTags() {
        return this.tags.size() != 0;
    }

    /**
     * Adds tags to this {@code Task}.
     * 
     * @param tags all the tags which will be added to this {@code Task}.''
     */
    public void addTags(String tags) {
        String[] tagsArr = tags.split(" ");
        for (int i = 0; i < tagsArr.length; i++) {
            this.tags.add(tagsArr[i]);
        }
    }

    /**
     * Deletes all the tags in this {@code Task}.
     */
    public void deleteTags() {
        this.tags.clear();
    }

    /**
     * Adds all the tags in this {@code Task} into a {@code String} for UI display.
     * 
     * @param str is the original {@code String} without tags added.
     * @return a {@code String} with the tags added if there is a tag.
     */
    protected String addTagsToString(String str) {
        if (this.hasTags()) {
            String tags = "";
            for (int i = 0; i < this.getTags().size(); i++) {
                tags += String.format(" #%s ", this.getTags().get(i));
            }
            str += tags;
        }
        return str;
    }

    /**
     * Describes the current {@code Task} object.
     * 
     * @return a description of the current {@code Task} object.
     */
    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.getDescription();
    }
}
