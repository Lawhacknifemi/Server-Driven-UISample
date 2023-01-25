"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ViewElementResolver = void 0;
exports.ViewElementResolver = {
    ViewElement: {
        __resolveType(obj) {
            if (obj.elements && obj.containerType) {
                return 'Container';
            }
            return null;
        }
    }
};
//# sourceMappingURL=view-element-resolver.js.map