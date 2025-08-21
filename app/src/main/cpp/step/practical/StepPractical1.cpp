#include <jni.h>
#include <memory>

namespace StepPractical1 {
    std::unique_ptr<int> price;
    std::unique_ptr<int> num;
    std::unique_ptr<int> money;

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_practical_StepPractical1_dataLoad(
            JNIEnv *env, jobject thiz, jboolean is_created
    ) {
        if (is_created) {
            price = std::make_unique<int>(100);
            num = std::make_unique<int>(1);
            money = std::make_unique<int>(1);
        } else {
            price.reset();
            num.reset();
            money.reset();
        }
    }

    extern "C"
    JNIEXPORT jint JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_practical_StepPractical1_num(
            JNIEnv *env, jobject thiz
    ) {
        return *num;
    }

    extern "C"
    JNIEXPORT jint JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_practical_StepPractical1_price(
            JNIEnv *env, jobject thiz
    ) {
        return *price;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_practical_StepPractical1_sub(
            JNIEnv *env, jobject thiz
    ) {
        if (*num > 1) {
            (*num)--;
        }
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_practical_StepPractical1_add(
            JNIEnv *env, jobject thiz
    ) {
        (*num)++;
    }

    extern "C"
    JNIEXPORT jint JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_practical_StepPractical1_money(
            JNIEnv *env, jobject thiz
    ) {
        return *money;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_practical_StepPractical1_buy(
            JNIEnv *env, jobject thiz
    ) {
        if (*num > 1) {
            int subMoney = *num * *price;
            if (*money > subMoney) {
                *money -= subMoney;
            }
        }
    }

    extern "C"
    JNIEXPORT jboolean JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_practical_StepPractical1_success(
            JNIEnv *env, jobject thiz
    ) {
        return *money > 2000000000;
    }
}