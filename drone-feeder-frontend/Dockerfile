FROM node:16-bullseye
WORKDIR /app
COPY . .
RUN yarn
RUN yarn build
EXPOSE 3000
CMD ["yarn", "dev"]