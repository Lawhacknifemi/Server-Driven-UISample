"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const glob_1 = require("glob");
const fs = __importStar(require("fs"));
const apollo_server_express_1 = require("apollo-server-express");
const resolvers_1 = require("./resolvers/resolvers");
const queries_1 = require("./queries/queries");
const graphqlFile = glob_1.glob.sync('./graphql/**/*.graphql');
let schema = '';
graphqlFile.forEach(elements => {
    try {
        const file = fs.readFileSync(elements, 'utf-8');
        schema += file;
    }
    catch (error) {
        console.log(error);
    }
});
async function startApolloServer(typeDefs, resolvers) {
    const app = (0, express_1.default)();
    const server = new apollo_server_express_1.ApolloServer({
        typeDefs,
        resolvers: {
            ...resolvers,
            ...queries_1.queries
        },
    });
    await server.start();
    server.applyMiddleware({ app });
    await new Promise(resolve => app.listen({ port: 4000 }, resolve));
    console.log(`Server is ready at http://localhost:4000${server.graphqlPath}`);
}
startApolloServer(schema, resolvers_1.resolvers);
//# sourceMappingURL=server.js.map