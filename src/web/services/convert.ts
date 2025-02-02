const romanizeInteger = async (inputValue: string): Promise<string> => {
  await new Promise((res) => {
    setTimeout(res, 2000);
  });

  return "xxvii";
};

const ConvertService = {
  romanizeInteger,
};

export default ConvertService;
