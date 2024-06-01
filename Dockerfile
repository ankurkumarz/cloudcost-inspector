# Stage 1 for Build
FROM adoptopenjdk/openjdk17:alpine as buildimage

# SSH key as a build argument, if passed
ARG SSH_PRIVATE_KEY

# Install dependencies required to git clone
RUN apk update && \
    apk add --update git && \
    apk add --update openssh

# 1. Create the SSH directory.
# 2. Populate the private key file.
# 3. Set the required permissions.
# 4. Add github to list of known hosts for ssh.
RUN mkdir -p /root/.ssh/ && \
    echo "$SSH_KEY" > /root/.ssh/id_rsa && \
    chmod -R 600 /root/.ssh/ && \
    ssh-keyscan -t rsa github.com >> ~/.ssh/known_hosts

# Clone
RUN mkdir -p /opt/cloudcost
RUN git clone https://github.com/ankurkumarz/cloudcost-inspector.git /opt/cloudcost
RUN cd /opt/cloudcost && git checkout main && git pull
RUN cd /opt/cloudcost && ls -l /opt/cloudcost && \
    ./gradlew assemble

# Stage 2 for Docker Image
FROM adoptopenjdk/openjdk17:alpine
RUN apk --no-cache add ca-certificates git openssh && \
  mkdir -p /opt/cloudcost
RUN addgroup -S clouduser && adduser -S clouduser -G clouduser

# Copy JAR file from Build
COPY --from=buildimage /opt/cloudcost/build/libs/CloudCostInspector.jar /opt/cloudcost/

USER clouduser:clouduser

EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/cloudcost/CloudCostInspector.jar"]
