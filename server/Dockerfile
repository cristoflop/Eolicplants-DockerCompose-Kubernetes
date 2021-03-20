FROM node:lts-alpine as builder
WORKDIR /usr/src/app/
COPY package.json /usr/src/app/
RUN npm install --only=production

FROM node:lts-alpine
RUN apk add --no-cache curl
RUN apk add --no-cache bash
WORKDIR /usr/src/app
RUN curl -LJO https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh && chmod +x /usr/src/app/wait-for-it.sh
COPY package.json /usr/src/app/
COPY --from=builder /usr/src/app/node_modules /usr/src/app/node_modules
COPY src /usr/src/app/src
COPY public /usr/src/app/public
COPY config /usr/src/app/config
EXPOSE 3000
CMD ["node", "src/server.js"]