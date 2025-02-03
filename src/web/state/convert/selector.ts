import type { RootState } from "@state/store";
import TypeUtils from "@utils/type-utils";

const selectInputValue = (state: RootState) => state.convert.inputValue;

const selectInputValueValid = (state: RootState) =>
  state.convert.inputValue !== "" &&
  TypeUtils.isIntString(state.convert.inputValue);

const selectConverting = (state: RootState) => state.convert.converting;

const selectResult = (state: RootState) => state.convert.result;

const ConvertSelectors = {
  converting: selectConverting,
  inputValid: selectInputValueValid,
  inputValue: selectInputValue,
  result: selectResult,
};

export default ConvertSelectors;
