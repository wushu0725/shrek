# shrek
springboot+springcloud+nacos

# 部署nacos,
# 下载源码
git clone https://github.com/alibaba/nacos.git

# 安装到本地仓库
cd nacos/
mvn -Prelease-nacos clean install -U

cd distribution/target/nacos-server-1.1.3/nacos/bin

# Windows
startup.cmd
