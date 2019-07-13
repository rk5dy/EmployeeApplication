FROM node:latest
RUN npm i -g react-scripts
COPY package.json package.json
RUN npm install
COPY . .
RUN npm start
