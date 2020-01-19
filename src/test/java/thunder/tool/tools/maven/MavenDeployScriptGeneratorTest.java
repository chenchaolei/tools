package thunder.tool.tools.maven;

import thunder.tool.tools.maven.MavenDeployScriptGenerator;

public class MavenDeployScriptGeneratorTest {

    public static void main(String[] args) {
        String[] testArgs = new String[]{
                "-DlocalRepositoryHome=/Users/Shared/m2/repository",
                "-DremoteSnapshotRepositoryUrl=http://gitlab.thunder/repository/maven-snapshots/",
                "-DremoteReleaseRepositoryUrl=http://gitlab.thunder/repository/maven-releases/",
                "-DrepositoryId=nexus",
                "-Dposition=com.bosssoft.pay:pay-sdk:1.0.0:jar"
        };
        MavenDeployScriptGenerator.main(testArgs);
    }
}
