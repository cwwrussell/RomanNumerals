import reducer, { INITIAL_STATE } from "./reducer";
import ConvertActions from "./actions";

describe("Convert reducer", () => {
  describe("_setInputValue", () => {
    const {
      private: { _setInputValue },
    } = ConvertActions;
    it("should set the input value in state", () => {
      const nextState = reducer(INITIAL_STATE, _setInputValue("54321"));
      expect(nextState.inputValue).toEqual("54321");
    });

    it("should reset the result value when it's NULL", () => {
      const nextState = reducer(
        { ...INITIAL_STATE, result: null },
        _setInputValue("54321"),
      );
      expect(nextState.result).toBeUndefined();
    });

    it("should NOT reset the result value when it's not NULL", () => {
      const nextState = reducer(
        { ...INITIAL_STATE, result: "XIX" },
        _setInputValue("54321"),
      );
      expect(nextState.result).toEqual("XIX");
    });
  });

  describe("convertInputValue", () => {
    const { convertInputValue } = ConvertActions;
    it("should set converting to TRUE when pending", () => {
      const nextState = reducer(
        { ...INITIAL_STATE, inputValue: "12" },
        convertInputValue.pending("reqId"),
      );
      expect(nextState.converting).toBe(true);
    });

    it("should set converting to FALSE when fulfilled", () => {
      const nextState = reducer(
        { ...INITIAL_STATE, inputValue: "12" },
        convertInputValue.fulfilled("XII", "reqId"),
      );
      expect(nextState.converting).toBe(false);
    });

    it("should set result when fulfilled", () => {
      const nextState = reducer(
        { ...INITIAL_STATE, inputValue: "12" },
        convertInputValue.fulfilled("XII", "reqId"),
      );
      expect(nextState.result).toBe("XII");
    });

    it("should set result to NULL when rejected", () => {
      const nextState = reducer(
        { ...INITIAL_STATE, inputValue: "4001" },
        convertInputValue.rejected(Error(), "reqId"),
      );
      expect(nextState.result).toBeNull();
    });

    it("should set converting to FALSE when rejected", () => {
      const nextState = reducer(
        { ...INITIAL_STATE, inputValue: "4001" },
        convertInputValue.rejected(Error(), "reqId"),
      );

      expect(nextState.converting).toBe(false);
    });
  });
});
