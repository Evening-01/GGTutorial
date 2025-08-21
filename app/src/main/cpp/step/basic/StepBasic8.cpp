#include <jni.h>
#include <memory>

namespace StepBasic8 {
    std::unique_ptr<int[]> data;

    int xorData(int xorNum, int xorKey) {
        return xorNum ^ xorKey;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic8_dataLoad(
            JNIEnv *env, jobject thiz, jboolean is_created
    ) {
        if (is_created) {
            data = std::make_unique<int[]>(2);
            data[0] = 2099;
            data[1] = 2024;
        } else {
            data.reset();
        }
    }

    extern "C"
    JNIEXPORT jint JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic8_num(
            JNIEnv *env, jobject thiz
    ) {
        return xorData(data[0], data[1]);
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic8_change(
            JNIEnv *env, jobject thiz
    ) {
        data[0] += 4;
    }

    extern "C"
    JNIEXPORT jboolean JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic8_success(
            JNIEnv *env, jobject thiz
    ) {
        return xorData(data[0], data[1]) == 9999;
    }
}