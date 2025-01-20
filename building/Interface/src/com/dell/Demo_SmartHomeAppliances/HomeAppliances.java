package com.dell.Demo_SmartHomeAppliances;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class HomeAppliances implements Switch{
    @Override
    public void press() {
        // 控制當前設備開關
        status = !status;
    }

    private String name;
    // 狀態：on/off
    private boolean status; // false 默認是關閉
}
