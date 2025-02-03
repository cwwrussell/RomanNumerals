import TypeUtils from "./type-utils";

describe("TypeUtils", () => {
  describe("isIntString", () => {
    it("should return FALSE when the string is empty", () => {
      expect(TypeUtils.isIntString("")).toBe(false);
    });

    it.each([{}, 0, null, undefined])(
      "should return FALSE when the value is not a string",
      (payload) => {
        expect(TypeUtils.isIntString(payload)).toBe(false);
      },
    );

    it.each(["0", "-1", "1", "249", "10.23", "-3.14159"])(
      "should return TRUE when the value can be parsed to an integer",
      (payload) => {
        expect(TypeUtils.isIntString(payload)).toBe(true);
      },
    );
  });
});
