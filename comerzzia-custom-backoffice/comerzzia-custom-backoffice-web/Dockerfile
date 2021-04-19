FROM docker-repo.tier1.es:5043/producto/comerzzia/backoffice:4.8.1-SNAPSHOT

RUN rm ${INSTALL_DIR}/wildfly/standalone/deployments/*.war

COPY ./target/*.war "${INSTALL_DIR}/wildfly/standalone/deployments/"
