import React, { type FC, useCallback } from "react";
import styles from "./converter-input.module.scss";
import FormControls from "@components/common/form-controls";
import { useDispatch, useSelector } from "react-redux";
import ConvertSelectors from "@state/convert/selector";
import ConvertActions from "@state/convert/actions";
import type { Action, ThunkDispatch } from "@reduxjs/toolkit";
import type { RootState } from "@state/store";

const ConverterInput: FC = () => {
  const dispatch: ThunkDispatch<RootState, void, Action> = useDispatch();
  const inputValue = useSelector(ConvertSelectors.inputValue);
  const isValid = useSelector(ConvertSelectors.inputValid);

  const onChange = useCallback((newValue: string) => {
    dispatch(ConvertActions.setInputValue(newValue.replace(/\D/g, "")));
  }, []);

  const onClickRomanize = useCallback(() => {
    dispatch(ConvertActions.convertInputValue());
  }, []);

  return (
    <div className={styles.ConverterInput}>
      <FormControls.TextBox
        value={inputValue}
        onChange={onChange}
        error={!isValid && inputValue !== ""}
        placeholder="Between 1 and 3999"
      />
      <FormControls.Button disabled={!isValid} onClick={onClickRomanize}>
        ROMANIZE
      </FormControls.Button>
    </div>
  );
};

export default ConverterInput;
