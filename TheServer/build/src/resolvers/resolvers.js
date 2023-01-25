"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.resolvers = void 0;
const container_resolver_1 = require("./container-resolver");
const view_element_resolver_1 = require("./view-element-resolver");
exports.resolvers = {
    ...view_element_resolver_1.ViewElementResolver,
    ...container_resolver_1.containerResolver
};
//# sourceMappingURL=resolvers.js.map