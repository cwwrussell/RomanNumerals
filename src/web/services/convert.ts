import HttpUtils from "@utils/http-utils";

const { unwrap } = HttpUtils;

interface RomanNumeralPayload {
  input: string;
  output: string;
}

const integerToRomanNumeral = async (
  inputValue: string,
): Promise<RomanNumeralPayload> =>
  fetch(`/romannumeral?query=${inputValue}`).then(unwrap);

const ConvertService = {
  integerToRomanNumeral,
};

export default ConvertService;
