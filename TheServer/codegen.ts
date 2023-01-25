
import type { CodegenConfig } from '@graphql-codegen/cli';

const config: CodegenConfig = {
  overwrite: true,
  schema: "src/schema.graphql",
  generates: {
    "src/types.ts": {
      plugins: ["typescript"]
    }
  }
};

export default config;
