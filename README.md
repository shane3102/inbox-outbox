# Inbox-Outbox

Library for implementing inbox/outbox pattern.

Library has implementations for two JVM frameworks, check for framework specific instructions: 
- [Spring boot](inbox-outbox-spring-boot/README.md)
- [Quarkus](inbox-outbox-quarkus/README.md)

### Deployment

Library is deployed to following reposilite repository: https://reposilite.shane3102.pl. 
In order to deploy new version you need 
to define username and password for specified reposilite in `./.m2/settings.xml` file
```xml
    <servers>
        <server>
            <id>Self hosted reposilite</id>
            <username>actual_username</username>
            <password>actual_password</password>
        </server>
    </servers>
```

Command:
```shell
mvn --settings ./.m2/settings.xml clean deploy
```

