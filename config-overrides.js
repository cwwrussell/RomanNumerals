const path = require("path");

module.exports = function override(config, env) {
  config.resolve = {
    ...(config.resolve ?? {}),
    alias: {
      ...(config.resolve?.alias ?? {}),
      "@styles": path.resolve(__dirname, "src/web/styles"),
      "@components": path.resolve(__dirname, "src/web/components/"),
      "@models": path.resolve(__dirname, "src/web/models/"),
      "@services": path.resolve(__dirname, "src/web/services/"),
      "@utils": path.resolve(__dirname, "src/web/utils/"),
      "@state": path.resolve(__dirname, "src/web/state/"),
    },
  };

  return config;
};
