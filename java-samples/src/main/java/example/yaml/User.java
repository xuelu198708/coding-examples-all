package example.yaml;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by xuelu
 * 2020-07-24.
 */
public class User {
    @JsonProperty
    private List<String> name;
    @JsonProperty
    private List<GroupType> groups;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<GroupType> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupType> groups) {
        this.groups = groups;
    }
}
