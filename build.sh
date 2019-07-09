#!/bin/sh
cd releng/com.yakindu.solidity.releng
# mvn clean verify -P$TARGET,tests
cd ../com.yakindu.solidity.repository/target
zip -r repository.zip repository
cd ../../../
# cd $TRAVIS_BUILD_DIR/extensions/vscode
# ./gradlew vscodeExtension
# cd $TRAVIS_BUILD_DIR
cp -r plugins/com.yakindu.solidity.ide/target/languageserver extensions/theia/docker/theia_app
cp -r extensions/theia/ide extensions/theia/docker/theia_app
docker build extensions/theia/docker/theia_app/. -t solidity-ide
# docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD 
# docker push yakindu/solidity-ide
