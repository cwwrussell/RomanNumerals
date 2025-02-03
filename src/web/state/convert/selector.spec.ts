import { INITIAL_STATE } from "@state/convert/reducer";
import ConvertSelectors from "@state/convert/selector";
import { RootState } from "@state/store";

describe("ConvertSelectors", () => {
  describe("selectInputValueValid", () => {
    it("should return FALSE when the input value is an empty string", () => {
      expect(
        ConvertSelectors.inputValid({
          convert: { ...INITIAL_STATE, inputValue: "" },
        }),
      ).toBe(false);
    });

    it.each([undefined, null, 9, {}, [], false])(
      "should return FALSE when the input value is not a string",
      (arg) => {
        expect(
          ConvertSelectors.inputValid({
            convert: { ...INITIAL_STATE, inputValue: arg },
          } as RootState),
        ).toBe(false);
      },
    );

    it("should return TRUE when the input value can be converted to an integer", () => {
      expect(
        ConvertSelectors.inputValid({
          convert: { ...INITIAL_STATE, inputValue: "456" },
        }),
      ).toBe(true);
    });
  });
});
