import {containerResolver} from "./container-resolver";
import {ViewElementResolver} from "./view-element-resolver";

export const  resolvers = {
  ...ViewElementResolver,
  ...containerResolver
}
