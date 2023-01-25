import express from "express"
import {glob} from "glob";
import * as fs from "fs";
import {ApolloServer} from 'apollo-server-express';
import {resolvers} from "./resolvers/resolvers";
import {queries} from "./queries/queries";

const graphqlFile =glob.sync('./graphql/**/*.graphql');
let schema = '';

graphqlFile.forEach( elements =>{
  try{
    const file = fs.readFileSync(elements, 'utf-8');
    schema+= file;
  }catch (error) {
    console.log(error);
  }
  }
)

async function startApolloServer(typeDefs : any, resolvers : any ){
  const app = express();
  const server =new ApolloServer({
    typeDefs,
    resolvers: {
      ...resolvers,
      ...queries
    },
  });
  await  server.start();
  server.applyMiddleware({app});
  await new Promise(resolve => app.listen({port: 4000}, resolve as ()=> void));
  console.log(`Server is ready at http://localhost:4000${server.graphqlPath}`)
}

startApolloServer(schema, resolvers)
