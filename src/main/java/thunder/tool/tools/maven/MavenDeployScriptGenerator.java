package thunder.tool.tools.maven;

public class MavenDeployScriptGenerator {

    /**
     * 生成maven仓库deploy脚本
     * @param args
     */
    public static void main(String[] args) {
        // 命令行支持的参数名称
        String LOCAL_REPOSITORY_HOME = "localRepositoryHome";
        String REMOTE_SNAPSHOT_REPOSITOR_URL = "remoteSnapshotRepositoryUrl";
        String REMOTE_RELEASE_REPOSITOR_URL = "remoteReleaseRepositoryUrl";
        String REPOSITOR_ID = "repositoryId";
        String POSITION = "position";

        // 参数模板
        String localRepositoryHomeTpl = "{localRepositoryHome}";
        String repositoryIdTpl = "{repositoryId}";
        String remoteRepositoryUrlTpl = "{remoteRepositoryUrl}";
        String artifactHomeTpl = "{artifactHome}";
        String groupIdTpl = "{groupId}";
        String artifactIdTpl = "{artifactId}";
        String versionTpl = "{version}";

        // aitifact模板
        String pomTemplate = "mvn deploy:deploy-file" +
                " -DgroupId=" + groupIdTpl +
                " -DartifactId=" + artifactIdTpl +
                " -Dversion=" + versionTpl +
                " -Dpackaging=pom" +
                " -DrepositoryId=" + repositoryIdTpl +
                " -Durl=" + remoteRepositoryUrlTpl +
                " -Dfile="+ localRepositoryHomeTpl + "/" + artifactHomeTpl + "/" + artifactIdTpl + "/" + versionTpl + "/" + artifactIdTpl + "-" + versionTpl + ".pom";

        String jarTemplate = "mvn deploy:deploy-file" +
                " -DgroupId=" + groupIdTpl +
                " -DartifactId=" + artifactIdTpl +
                " -Dversion=" + versionTpl +
                " -DgeneratePom=false" +
                " -Dpackaging=jar" +
                " -DrepositoryId=" + repositoryIdTpl +
                " -Durl=" + remoteRepositoryUrlTpl +
                " -DpomFile="+ localRepositoryHomeTpl + "/" + artifactHomeTpl + "/"+ artifactIdTpl + "/" + versionTpl + "/" + artifactIdTpl + "-" + versionTpl + ".pom" +
                " -Dfile="+ localRepositoryHomeTpl + "/" + artifactHomeTpl + "/"+ artifactIdTpl + "/" + versionTpl + "/" + artifactIdTpl + "-" + versionTpl  + ".jar";

        String warTemplate = "mvn deploy:deploy-file" +
                " -DgroupId=" + groupIdTpl +
                " -DartifactId=" + artifactIdTpl +
                " -Dversion=" + versionTpl +
                " -DgeneratePom=false" +
                " -Dpackaging=war" +
                " -DrepositoryId=" + repositoryIdTpl +
                " -Durl=" + remoteRepositoryUrlTpl +
                " -DpomFile="+ localRepositoryHomeTpl + "/" + artifactHomeTpl + "/" + artifactIdTpl + "/" + versionTpl + "/" + artifactIdTpl + "-" + versionTpl  + ".pom" +
                " -Dfile="+ localRepositoryHomeTpl + "/" + artifactHomeTpl + "/" + artifactIdTpl + "/" + versionTpl + "/" + artifactIdTpl + "-" + versionTpl  + ".war";

        // aitifact坐标
        String position = System.getProperty(POSITION);
        // 本地maven仓库根路径, 该目录用于定位artifact的位置. 最好在当前用户目录下, 否则可能存在上传失败的风险。
        String localRepositoryHome = System.getProperty(LOCAL_REPOSITORY_HOME);
        String repositoryId = System.getProperty(REPOSITOR_ID);
        String[] segments = position.split(":");
        String groupId = segments[0];
        String artifactId = segments[1];
        String version = segments[2];
        String plackageing = segments[3];
        String remoteRepositoryUrl = version.contains("-SNAPSHOT") ?
                System.getProperty(REMOTE_SNAPSHOT_REPOSITOR_URL)
                : System.getProperty(REMOTE_RELEASE_REPOSITOR_URL);

        String template = null;
        if (plackageing.equals("pom")) {
            template = pomTemplate;
        } else if (plackageing.equals("jar")) {
            template = jarTemplate;
        } else if (plackageing.equals("war")) {
            template = warTemplate;
        }

        template = template.replace(groupIdTpl, groupId);
        template = template.replace(artifactIdTpl, artifactId);
        template = template.replace(versionTpl, version);
        template = template.replace(localRepositoryHomeTpl, localRepositoryHome);
        template = template.replace(artifactHomeTpl, groupId.replace(".", "/"));
        template = template.replace(remoteRepositoryUrlTpl, remoteRepositoryUrl);
        template = template.replace(repositoryIdTpl, repositoryId);

        System.out.println("\n" + template);
    }
}
