const isIntString = (value: string): boolean =>
  value !== "" && !isNaN(parseInt(value, 10));

const TypeUtils = {
  isIntString,
};

export default TypeUtils;
