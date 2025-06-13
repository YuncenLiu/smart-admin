FROM registry.cn-beijing.aliyuncs.com/yuncenliu/openjdk:17-jdk
ENV TZ Asia/Shanghai

MAINTAINER yuncenliu@163.com

RUN mkdir -p /data/smart_admin/logs

WORKDIR /data

EXPOSE 8075

ADD ./sa-admin/target/sa-admin-prod-3.0.0.jar ./app.jar

ENTRYPOINT ["sh", "-c", "java -jar app.jar --spring.profiles.active=prod  >> /data/smart_admin/logs/log.log 2>&1 & tail -f /data/smart_admin/logs/log.log"]

# docker build -f Dockerfile -t registry.cn-beijing.aliyuncs.com/yuncenliu/smart-admin:3.0.0.RELEASE .
# docker run -itd --name smart-admin -p 8075:8075  registry.cn-beijing.aliyuncs.com/yuncenliu/smart-admin:3.0.0.RELEASE
# docker logs -f smart-admin

# docker stop smart-admin
# docker rm smart-admin
# docker rmi registry.cn-beijing.aliyuncs.com/yuncenliu/smart-admin:3.0.0.RELEASE

# docker push registry.cn-beijing.aliyuncs.com/yuncenliu/smart-admin:3.0.0.RELEASE
# docker pull registry.cn-beijing.aliyuncs.com/yuncenliu/smart-admin:3.0.0.RELEASE
