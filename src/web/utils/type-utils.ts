const isIntString = (value: unknown): boolean =>
  typeof value === "string" && !isNaN(parseInt(value, 10));

const TypeUtils = {
  isIntString,
};

export default TypeUtils;
