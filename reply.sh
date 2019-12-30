#!/usr/bin/env bash
echo -e "\033[31m1.是否更新代码 \033[0m"
select isPullCode in "YES" "NO"; do
  break;
done

if [ $isPullCode = "YES" ]; then
    echo -e "\033[34m Is Pull Code: $isPullCode \033[0m"
    git pull
else
    echo -e "\033[34m Is Pull Code: $isPullCode \033[0m"
    push=""
fi

echo -e "\033[31m2.请选择需要编译并推送镜像的项目 \033[0m"
select app in "blogyg-server-eureka" "blogyg-server-client" "blogyg-server-gateway" "blogyg-server-feign" "blogyg-server-ribbon" "blogyg-server-zuul" "blogyg-server-zipkin" "blogyg-server-monitor"; do
  break;
done

echo -e "\033[34m You have selected $app \033[0m"

# 切换目录
cd $app

#执行打包
mvn clean package docker:build

docker push harbor.blogyg.cn/blogyg/$app:v1.0.0

echo -e "push docker images : harbor.blogyg.cn/blogyg/$app:v1.0.0"
