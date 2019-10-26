package org.eclipse.aether.examples;
/**
 * @Project: dubbo-postman
 * @Package com.dubbo.postman.service.maven
 * @Description: TODO
 * @author : shengfeng.chen
 * @date Date : 2019年10月20日 17:18
 * @version V1.0
 */

/**
 * @ClassName Params
 * @Author chenshengfeng
 * @Date 2019-10-20 17:18
 **/
public class Params {

    private String groupId;

    private String artifactId;

    private String version;

    private String repository = "http://nexus.51caocao.cn/content/groups/public";

    private String target = "./target/local-repo";

    private String username = "chenshengfeng";

    private String password = "Shanghai123$";


    public Params() {
        super();
    }

    public Params(String groupId, String artifactId) {
        super();
        this.groupId = groupId;
        this.artifactId = artifactId;
    }

    public Params(String groupId, String artifactId, String username,
                  String password) {
        super();
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.username = username;
        this.password = password;
    }

    public Params(String groupId, String artifactId, String version,
                  String repository, /*String target,*/ String username, String password) {
        super();
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.repository = repository;
        /*this.target = target;*/
        this.username = username;
        this.password = password;
    }

    public Params(String groupId, String artifactId, String version,
                  String username, String password) {
        super();
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.username = username;
        this.password = password;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getTarget() {
        return target;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
