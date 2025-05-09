#!/bin/bash

# /Users/xiang/.nvm/versions/node/v20.19.1/bin/npm run build:prod

## 定义要修改的文件路径
#FILE="/Users/xiang/xiang/study/myproject/Blog-Project/smart-admin/smart-admin-web-typescript/dist/index.html"
#
## 执行替换操作（使用 # 作为分隔符避免转义）
#sed -i '' 's#src="/js/#src="https://xiang-1305498579.cos.ap-beijing.myqcloud.com/smart-admin/dns/js/#g' "$FILE"
#sed -i '' 's#href="/js/#href="https://xiang-1305498579.cos.ap-beijing.myqcloud.com/smart-admin/dns/js/#g' "$FILE"
#sed -i '' 's#href="/css/#href="https://xiang-1305498579.cos.ap-beijing.myqcloud.com/smart-admin/dns/css/#g' "$FILE"
#
#echo "替换完成"


## 激活虚拟环境
#source /Users/xiang/xiang/study/Python/tencent_cos_push/venv/bin/activate
## 执行 Python 脚本
#python /Users/xiang/xiang/study/Python/tencent_cos_push/smart_admin_push_mac.py
## 可选：如果需要在脚本执行完成后退出虚拟环境，可以添加 deactivate
#deactivate


## 删除历史部署
#rm -rf ./deploy
#
## 更新最新部署文件
#cp -r ./dist ./deploy
#
#git add .
#git add .
#git commit -m "deploy: MAC 端，$(Get-Date -Format 'yyyy-MM-dd HH:mm:ss') 自动部署提交"
#git push -u "origin" "master"
#git push -u "gitee" "master"



#curl -X POST \
#  http://39.105.177.10:8079/deploy \
#  -H "Authorization: Basic $(echo -n 'admin:password' | base64)" \
#  -H "Content-Type: application/json" \
#  -d '{"deploy":"xiang-admin"}'
#
#
#
