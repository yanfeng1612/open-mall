# open-mall

## 应用

## 部署端口

| 应用 | 用途 | 测试环境端口 | 域名 | 备注 |
| ---- | ---- | ----------- | ---- | ---- |
| open-mall-registry | 注册中心 |  8761 | registry.open-mall.com | |
| open-mall-gateway-admin | 后台网关 | 9000 | admin-gateway.open-mall.com | |
| open-mall-gateway-admin | 前台网关 | 9004 | api-gateway.open-mall.com | |
| open-mall-user | 用户中心 | 9001 | | |
| open-mall-product | 商品中心 | 9002 | | |
| open-mall-trade | 订单中心 | 9003 | | |


## 如何部署
1. 部署机器的操作系统版本  Linux-Debian

2. 安装docker
docker 版本 19.03.8 安装参见https://docs.docker.com/engine/install/debian/#install-using-the-repository.

3.打包镜像
docker build -t open-mall/open-mall-${app} .

4.docker容器执行
docker run -p port:port -t open-mall/open-mall-${app}

## 关于读写分离