import {
  type Action,
  configureStore,
  type ThunkDispatch,
} from "@reduxjs/toolkit";
import convert from "./convert/reducer";

const store = configureStore({
  reducer: {
    convert,
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type GetState = () => RootState;
export type AppDispatch = ThunkDispatch<RootState, void, Action>;

export default store;
