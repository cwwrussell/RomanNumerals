import ServiceUtils from "./service-utils";

describe("ServiceUtils", () => {
  describe("succeeded", () => {
    it.each(["payload", 0, "", {}, [], [1, 2, 3], { test: "value" }])(
      "should return FALSE when the payload is not NULL or UNDEFINED",
      (payload) => {
        expect(ServiceUtils.succeeded(payload)).toBe(true);
      },
    );

    it.each([null, undefined])(
      "should return FALSE when the payload is NULL or UNDEFINED",
      (payload) => {
        expect(ServiceUtils.succeeded(payload)).toBe(false);
      },
    );
  });

  describe("failed", () => {
    it("should return TRUE when the payload is NULL", () => {
      expect(ServiceUtils.failed(null)).toBe(true);
    });

    it.each(["", {}, 0, [], "payload", undefined])(
      "should return FALSE when the payload is not NULL",
      (payload) => {
        expect(ServiceUtils.failed(payload)).toBe(false);
      },
    );
  });

  describe("pending", () => {
    it("should return TRUE when the payload is UNDEFINED", () => {
      expect(ServiceUtils.pending(undefined)).toBe(true);
    });

    it.each([null, "", 0, {}, [], "payload"])(
      "should return FALSE when the payload is not UNDEFINED",
      (payload) => {
        expect(ServiceUtils.pending(payload)).toBe(false);
      },
    );
  });
});
