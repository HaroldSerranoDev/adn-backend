#FROM openjdk:8 AS TEMP_BUILD_IMAGE
#CMD ["gradle"]
#
#ENV GRADLE_HOME /opt/gradle
#
#RUN set -o errexit -o nounset \
#    && echo "Adding gradle user and group" \
#    && groupadd --system --gid 1000 gradle \
#    && useradd --system --gid gradle --uid 1000 --shell /bin/bash --create-home gradle \
#    && mkdir /home/gradle/.gradle \
#    && chown --recursive gradle:gradle /home/gradle \
#    \
#    && echo "Symlinking root Gradle cache to gradle Gradle cache" \
#    && ln -s /home/gradle/.gradle /root/.gradle
#
#VOLUME /home/gradle/.gradle
#
#WORKDIR /home/gradle
#
#RUN apt-get update \
#    && apt-get install --yes --no-install-recommends \
#        fontconfig \
#        unzip \
#        wget \
#        \
#        bzr \
#        git \
#        git-lfs \
#        mercurial \
#        openssh-client \
#        subversion \
#    && rm -rf /var/lib/apt/lists/*
#
#ENV GRADLE_VERSION 6.0.1
#ARG GRADLE_DOWNLOAD_SHA256=d364b7098b9f2e58579a3603dc0a12a1991353ac58ed339316e6762b21efba44
#RUN set -o errexit -o nounset \
#    && echo "Downloading Gradle" \
#    && wget --no-verbose --output-document=gradle.zip "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" \
#    \
#    && echo "Checking download hash" \
#    && echo "${GRADLE_DOWNLOAD_SHA256} *gradle.zip" | sha256sum --check - \
#    \
#    && echo "Installing Gradle" \
#    && unzip gradle.zip \
#    && rm gradle.zip \
#    && mv "gradle-${GRADLE_VERSION}" "${GRADLE_HOME}/" \
#    && ln --symbolic "${GRADLE_HOME}/bin/gradle" /usr/bin/gradle \
#    \
#    && echo "Testing Gradle installation" \
#    && gradle --version
#
#
#ENV APP_HOME=/usr/app/
#ENV MICROSERVICIO=/usr/app/microservicio
#WORKDIR $APP_HOME
#COPY . .
#RUN chmod +x $GRADLE_HOME
#WORKDIR $MICROSERVICIO
#RUN gradle --b build.gradle clean
#RUN gradle build -x test
#
#FROM openjdk:8
#ENV JAR_NAME=alquiler-motos-0.0.1-SNAPSHOT.jar
#ENV APP_HOME=/usr/app
##ENV SLEEP_SCRIPT=waitfor.sh
#WORKDIR $APP_HOME
#EXPOSE 8084
#COPY --from=TEMP_BUILD_IMAGE $APP_HOME/microservicio/build/libs/$JAR_NAME .
##COPY ./$SLEEP_SCRIPT .
##CMD sh $SLEEP_SCRIPT && java -jar $JAR_NAME
#CMD java -jar $JAR_NAME
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=microservicio/build/libs/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","/app.jar"]