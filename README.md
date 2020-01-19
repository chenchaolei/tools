# tools
## 用途
记录工具集
## 使用
| # | Name| MainClass | Background+Scene | Use | FAQ |
|---| ---| --- | --- | --- | --- |
| 1 | Maven Deploy脚本生成器 | [MavenDeployScriptGenerator](http://github.com/chenchaoleicn/tools/tree/master/src/main/java/thunder/tool/tools/maven/MavenDeployScriptGenerator.java) | 用于上传artifact到Nexus服务器。Nexus服务的界面不支持上传Snapshot版本的artifact，可以通过mvn:deploy来上传。 | 1.编译<br/> 2.进入工程/target/classes目录<br/> 3.在终端执行`java  -DlocalRepositoryHome="<localRepositoryHome>" -DremoteSnapshotRepositoryUrl="<remoteSnapshotRepositoryUrl>" -DremoteReleaseRepositoryUrl="<remoteReleaseRepositoryUrl>" -DrepositoryId="<repositoryId>" -Dposition="<position>" thunder.tool.tools.maven.MavenDeployScriptGenerator`<br/><br/>例如:`java  -DlocalRepositoryHome="/Users/user/m2/repository" -DremoteSnapshotRepositoryUrl="http://nexus.thunder/repository/maven-snapshots/" -DremoteReleaseRepositoryUrl="http://nexus.thunder/repository/maven-releases/" -DrepositoryId="nexus" -Dposition="thunder.pay:pay-sdk:1.0.0-SNAPSHOT:jar" thunder.tool.tools.maven.MavenDeployScriptGenerator` | 1.部署脚本报401，权限问题，检查在maven当前使用的settings.xml中server节点，是否与-DrepositoryId的值匹配，且节点值能通过验证。<br/> 2.用户本地仓库目录没在当前用户空间下，会导致上传失败。<br/> 3.在终端执行java命令时，出现Properties init错误，重新进入工程target/classes目录即可。其对应的错误信息:`Error occurred during initialization of VM`<br/>`    java.lang.Error: Properties init: Could not determine current working directory.` |
## 贡献
欢迎提交代码，有问题可以建`issue`。