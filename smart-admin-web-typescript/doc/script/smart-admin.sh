#!/bin/bash

# 部署在 liuyuncen.com 服务器中，/root/deploy/sakura.sh
# 作用是更新 sakura 主站

# 定义颜色
GREEN='\033[0;32m'
YELLOW='\033[0;33m'
RED='\033[0;31m'
NC='\033[0m' # 没有颜色


# 打印开始信息
echo -e "${GREEN}==> 开始执行脚本: 下拉Git，获取最新静态文件${NC}"


cd /root/deploy/workspace/smart-admin
git pull

# 备份
mv /home/xiang/service/smart-admin /data/back/smart-admin/smart-admin-$(date "+%Y-%m-%d_%H-%M-%S")

echo -e "${GREEN}==> 获取文件成功，文件已备份到 /data/back/smart-admin/smart-admin$(date "+%Y-%m-%d_%H-%M-%S")${NC}"

mkdir -p /home/xiang/service/smart-admin/
cp -r /root/deploy/workspace/smart-admin/smart-admin-web-typescript/deploy/* /home/xiang/service/smart-admin/


echo -e "${GREEN}==> 任务执行完成！${NC}"

