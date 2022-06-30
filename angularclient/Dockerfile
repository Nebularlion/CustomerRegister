FROM node:14.19-alpine
WORKDIR app
COPY . .
RUN npm i
EXPOSE 4200
CMD ["npm", "run", "start"]