#include <jni.h>
#include <memory>
#include <string>
#include <random>

namespace StepBasic7 {
    std::unique_ptr<std::string> user;

    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<> randomChar('A', 'Z');

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic7_dataLoad(
            JNIEnv *env, jobject thiz, jboolean is_created
    ) {
        if (is_created) {
            user = std::make_unique<std::string>("Hello");
        } else {
            user.reset();
        }
    }

    extern "C"
    JNIEXPORT jstring JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic7_user(
            JNIEnv *env, jobject thiz
    ) {
        return env->NewStringUTF(user->c_str());
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic7_switch(
            JNIEnv *env, jobject thiz
    ) {
        std::string newUser;
        for (int i = 0; i < 5; ++i) {
            newUser += static_cast<char>(randomChar(gen));
        }
        user = std::make_unique<std::string>(newUser);
    }

    extern "C"
    JNIEXPORT jboolean JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic7_success(
            JNIEnv *env, jobject thiz
    ) {
        return *user == "Admin";
    }
}