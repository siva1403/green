!/bin/bash
sudo apt-get update
sudo apt-get install -y openjdk-11-jre
sudo apt-get install -y maven
sudo apt-get install -y curl
curl -sfL https://raw.githubusercontent.com/aquasecurity/trivy/main/contrib/install.sh | sudo sh -s -- -b /usr/local/bin v0.57.0
mvn clean install
sudo apt-get install -y docker.io
sudo systemctl start docker
sudo systemctl enable docker
sudo bash
docker build -t my-java-app .
